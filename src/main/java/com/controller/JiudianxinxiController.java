package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiudianxinxiEntity;
import com.entity.view.JiudianxinxiView;

import com.service.JiudianxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 酒店信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
@RestController
@RequestMapping("/jiudianxinxi")
public class JiudianxinxiController {
    @Autowired
    private JiudianxinxiService jiudianxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiudianxinxiEntity jiudianxinxi,
		HttpServletRequest request){
        EntityWrapper<JiudianxinxiEntity> ew = new EntityWrapper<JiudianxinxiEntity>();

		PageUtils page = jiudianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiudianxinxiEntity jiudianxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiudianxinxiEntity> ew = new EntityWrapper<JiudianxinxiEntity>();

		PageUtils page = jiudianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudianxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiudianxinxiEntity jiudianxinxi){
       	EntityWrapper<JiudianxinxiEntity> ew = new EntityWrapper<JiudianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiudianxinxi, "jiudianxinxi")); 
        return R.ok().put("data", jiudianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiudianxinxiEntity jiudianxinxi){
        EntityWrapper< JiudianxinxiEntity> ew = new EntityWrapper< JiudianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiudianxinxi, "jiudianxinxi")); 
		JiudianxinxiView jiudianxinxiView =  jiudianxinxiService.selectView(ew);
		return R.ok("查询酒店信息成功").put("data", jiudianxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiudianxinxiEntity jiudianxinxi = jiudianxinxiService.selectById(id);
        return R.ok().put("data", jiudianxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiudianxinxiEntity jiudianxinxi = jiudianxinxiService.selectById(id);
        return R.ok().put("data", jiudianxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiudianxinxiEntity jiudianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiudianxinxi);
        jiudianxinxiService.insert(jiudianxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiudianxinxiEntity jiudianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiudianxinxi);
        jiudianxinxiService.insert(jiudianxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiudianxinxiEntity jiudianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiudianxinxi);
        jiudianxinxiService.updateById(jiudianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiudianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
