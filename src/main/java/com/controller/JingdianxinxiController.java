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

import com.entity.JingdianxinxiEntity;
import com.entity.view.JingdianxinxiView;

import com.service.JingdianxinxiService;
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
 * 景点信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
@RestController
@RequestMapping("/jingdianxinxi")
public class JingdianxinxiController {
    @Autowired
    private JingdianxinxiService jingdianxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi,
		HttpServletRequest request){
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();

		PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi, 
		HttpServletRequest request){
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();

		PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingdianxinxiEntity jingdianxinxi){
       	EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingdianxinxi, "jingdianxinxi")); 
        return R.ok().put("data", jingdianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingdianxinxiEntity jingdianxinxi){
        EntityWrapper< JingdianxinxiEntity> ew = new EntityWrapper< JingdianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingdianxinxi, "jingdianxinxi")); 
		JingdianxinxiView jingdianxinxiView =  jingdianxinxiService.selectView(ew);
		return R.ok("查询景点信息成功").put("data", jingdianxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingdianxinxiEntity jingdianxinxi = jingdianxinxiService.selectById(id);
		jingdianxinxi.setClicknum(jingdianxinxi.getClicknum()+1);
		jingdianxinxi.setClicktime(new Date());
		jingdianxinxiService.updateById(jingdianxinxi);
        jingdianxinxi = jingdianxinxiService.selectView(new EntityWrapper<JingdianxinxiEntity>().eq("id", id));
        return R.ok().put("data", jingdianxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingdianxinxiEntity jingdianxinxi = jingdianxinxiService.selectById(id);
		jingdianxinxi.setClicknum(jingdianxinxi.getClicknum()+1);
		jingdianxinxi.setClicktime(new Date());
		jingdianxinxiService.updateById(jingdianxinxi);
        jingdianxinxi = jingdianxinxiService.selectView(new EntityWrapper<JingdianxinxiEntity>().eq("id", id));
        return R.ok().put("data", jingdianxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.insert(jingdianxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.insert(jingdianxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingdianxinxiEntity jingdianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingdianxinxi);
        jingdianxinxiService.updateById(jingdianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingdianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JingdianxinxiEntity jingdianxinxi, HttpServletRequest request,String pre){
        EntityWrapper<JingdianxinxiEntity> ew = new EntityWrapper<JingdianxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = jingdianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianxinxi), params), params));
        return R.ok().put("data", page);
    }










}
