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

import com.entity.PiaowuleixingEntity;
import com.entity.view.PiaowuleixingView;

import com.service.PiaowuleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 票务类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
@RestController
@RequestMapping("/piaowuleixing")
public class PiaowuleixingController {
    @Autowired
    private PiaowuleixingService piaowuleixingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PiaowuleixingEntity piaowuleixing,
		HttpServletRequest request){
        EntityWrapper<PiaowuleixingEntity> ew = new EntityWrapper<PiaowuleixingEntity>();

		PageUtils page = piaowuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, piaowuleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PiaowuleixingEntity piaowuleixing, 
		HttpServletRequest request){
        EntityWrapper<PiaowuleixingEntity> ew = new EntityWrapper<PiaowuleixingEntity>();

		PageUtils page = piaowuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, piaowuleixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PiaowuleixingEntity piaowuleixing){
       	EntityWrapper<PiaowuleixingEntity> ew = new EntityWrapper<PiaowuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( piaowuleixing, "piaowuleixing")); 
        return R.ok().put("data", piaowuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PiaowuleixingEntity piaowuleixing){
        EntityWrapper< PiaowuleixingEntity> ew = new EntityWrapper< PiaowuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( piaowuleixing, "piaowuleixing")); 
		PiaowuleixingView piaowuleixingView =  piaowuleixingService.selectView(ew);
		return R.ok("查询票务类型成功").put("data", piaowuleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PiaowuleixingEntity piaowuleixing = piaowuleixingService.selectById(id);
        return R.ok().put("data", piaowuleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PiaowuleixingEntity piaowuleixing = piaowuleixingService.selectById(id);
        return R.ok().put("data", piaowuleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PiaowuleixingEntity piaowuleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(piaowuleixing);
        piaowuleixingService.insert(piaowuleixing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PiaowuleixingEntity piaowuleixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(piaowuleixing);
        piaowuleixingService.insert(piaowuleixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PiaowuleixingEntity piaowuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(piaowuleixing);
        piaowuleixingService.updateById(piaowuleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        piaowuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
