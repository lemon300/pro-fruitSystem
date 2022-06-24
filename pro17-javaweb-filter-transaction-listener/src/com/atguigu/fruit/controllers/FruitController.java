package com.atguigu.fruit.controllers;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.fruit.service.FruitService;
import com.atguigu.fruit.service.impl.FruitServiceImpl;
import com.atguigu.fruit.utils.StringUtils;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @ClassNmae FruitServlet
 * @Description TODO
 * @Author twj280
 * @Date 2022/4/20 13:28
 * @Version 1.0
 **/

public class FruitController {
    private FruitService fruitService = null;

    protected String index(String oper, String keywords, Integer pageNo, HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (pageNo == null) {
            pageNo = 1;
        }

        if (StringUtils.isNotEmpty(oper) && "search".equals(oper)) {
            if (StringUtils.isEmpty(keywords)) {
                keywords = "";
            }
            session.setAttribute("keywords", keywords);
        } else {
            //没有点击查询按钮，而是点击是首页 下一页，上一页，尾页


            Object keywordsObj = session.getAttribute("keywords");
            if (keywordsObj != null) {
                keywords = (String) keywordsObj;
            } else {
                keywords = "";
            }
        }


        int pageTotal = fruitService.getPageCount(keywords);

        List fruitList = fruitService.getFruitList(keywords,pageNo);
        session.setAttribute("fruitList", fruitList);
        session.setAttribute("pageTotal", pageTotal);
        session.setAttribute("pageNo", pageNo);

        //此处的视图名称时：index
        //那么thymeleaf会将这个 逻辑视图名称  对应到 物理视图 名称上去
        //逻辑视图名称： index
        //物理视图名称： view-prefix  + 逻辑视图名称  +  view-suffix

        //所以 真实的视图名称是：  /      index    .html
//        processTemplate("fruit.do",request,response);
        return "fruit.do";

    }

    protected String edit(Integer fid, HttpServletRequest request) {
        if (fid != null) {
            Fruit fruit =fruitService.getFruitById(fid);
            request.setAttribute("fruit", fruit);
//            super.processTemplate("edit",request,response);
            return "edit";
        }
        return "error";
    }

    protected String add(String fname, BigDecimal price, Integer fcount, String remark) {
        fruitService.addFruit(new Fruit(fname, price, fcount, remark));
//        response.sendRedirect("fruit.do");
        return "redirect:fruit.do";


    }

    protected String delete(Integer fid) {
        if (fid != null) {
            fruitService.deleteFruitById(fid);
//            response.sendRedirect("fruit.do");
            return "redirect:fruit.do";
        }
        return "error";
    }

    protected String update(Integer fid, String fname, BigDecimal price, Integer fcount, String remark) {

        if (fid != null) {
            fruitService.updateFruit(new Fruit(fname, price, fcount, remark));
//        response.sendRedirect("fruit.do");
            return "redirect:fruit.do";
        }
        return "error";
    }

}
