package site.ccczg.service;

import site.ccczg.dao.FangYuanDao;
import site.ccczg.dao.impl.FangYuanDaoImpl;
import site.ccczg.domain.FangYuanCar;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Effort
 * @Date: 2019/7/17 22:56
 * @Description:
 */
public class RepoPageProcessor implements PageProcessor {

    private static final String REGEX_PAGE_URL = "http://www\\.fangyuanqiche\\.com/Cars/index/sort/3/status/0/p/\\w+.html";
    /**
     * 爬取的页数
     */
    private static final int PAGE_SIZE = 68;

    private Site site = Site.me().
            setRetrySleepTime(3).
            setSleepTime(1000);

    @Override
    public Site getSite () {
        return site;
    }

    @Override
    public void process(Page page) {
        //分页里的连接
        List<String> targets= new ArrayList<>();

        for (int i = 1; i <= PAGE_SIZE; i++) {
            targets.add("http://www.fangyuanqiche.com/Cars/index/sort/3/status/0/p/"+i+".html");
            page.addTargetRequests(targets);
        }

        //二手车列表页
        if (page.getUrl().regex(REGEX_PAGE_URL).match()) {
            //获取列表页车辆详情链接
            List<String> details = page.getHtml().xpath("//div[@class='carTxt right dInline']/h2/a").links().all();
            page.addTargetRequests(details);
        }
        //车辆详情页
        else {
            FangYuanCar fangYuanCar = new FangYuanCar();
            //车辆信息
            String massage = page.getHtml().xpath("//div[@class='buyTxt right dInline']/h1/text()").toString();
            fangYuanCar.setMassage(massage);
            //上牌时间
            String cardsdate = page.getHtml().xpath("//div[@class='byDl clearfix byDl_tab']/span[1]/div/p/text()").toString().trim();
            fangYuanCar.setCardsdate(cardsdate);
            //行车里程
            String mileage = page.getHtml().xpath("//div[@class='byDl clearfix byDl_tab']/span[2]/div/p/text()").toString().trim();
            fangYuanCar.setMileage(cardsdate);
            // 出厂日期
            String factorydate = page.getHtml().xpath("//div[@class='byDl clearfix byDl_tab']/span[3]/div/p/text()").toString().trim();
            fangYuanCar.setFactorydate(factorydate);
            //新车价格
            String newcarprices = page.getHtml().xpath("//p[@style='padding-top: 6px; font-size: 15px;']/text()").toString().trim().substring(5);
            fangYuanCar.setNewcarprices(newcarprices);
            //一口价
            String fixedprice = page.getHtml().xpath("//div[@class='byDl clearfix']/div[@class='price']/span[@class='num nBlue']/text()").toString().trim()+"万";
            fangYuanCar.setFixedprice(fixedprice);
            System.out.println(fangYuanCar);

            FangYuanDao dao = new FangYuanDaoImpl();
            //插入数据库
            dao.add(fangYuanCar);
        }
    }

    public static void main(String [] args) {
        //起始URL，开启的线程数为20个
        Spider.create(new RepoPageProcessor()).addUrl("http://www.fangyuanqiche.com/Cars/index/sort/3/status/0/p/1.html").thread(20).run();
    }
}


