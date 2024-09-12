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

import com.entity.DiscusslvyoujihuaEntity;
import com.entity.view.DiscusslvyoujihuaView;

import com.service.DiscusslvyoujihuaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 旅游计划评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 22:55:49
 */
@RestController
@RequestMapping("/discusslvyoujihua")
public class DiscusslvyoujihuaController {
    @Autowired
    private DiscusslvyoujihuaService discusslvyoujihuaService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusslvyoujihuaEntity discusslvyoujihua,
		HttpServletRequest request){
        EntityWrapper<DiscusslvyoujihuaEntity> ew = new EntityWrapper<DiscusslvyoujihuaEntity>();

		PageUtils page = discusslvyoujihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusslvyoujihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusslvyoujihuaEntity discusslvyoujihua, 
		HttpServletRequest request){
        EntityWrapper<DiscusslvyoujihuaEntity> ew = new EntityWrapper<DiscusslvyoujihuaEntity>();

		PageUtils page = discusslvyoujihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusslvyoujihua), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusslvyoujihuaEntity discusslvyoujihua){
       	EntityWrapper<DiscusslvyoujihuaEntity> ew = new EntityWrapper<DiscusslvyoujihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusslvyoujihua, "discusslvyoujihua")); 
        return R.ok().put("data", discusslvyoujihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusslvyoujihuaEntity discusslvyoujihua){
        EntityWrapper< DiscusslvyoujihuaEntity> ew = new EntityWrapper< DiscusslvyoujihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusslvyoujihua, "discusslvyoujihua")); 
		DiscusslvyoujihuaView discusslvyoujihuaView =  discusslvyoujihuaService.selectView(ew);
		return R.ok("查询旅游计划评论表成功").put("data", discusslvyoujihuaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusslvyoujihuaEntity discusslvyoujihua = discusslvyoujihuaService.selectById(id);
        return R.ok().put("data", discusslvyoujihua);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusslvyoujihuaEntity discusslvyoujihua = discusslvyoujihuaService.selectById(id);
        return R.ok().put("data", discusslvyoujihua);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusslvyoujihuaEntity discusslvyoujihua, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusslvyoujihua);
        discusslvyoujihuaService.insert(discusslvyoujihua);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusslvyoujihuaEntity discusslvyoujihua, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusslvyoujihua);
        discusslvyoujihuaService.insert(discusslvyoujihua);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusslvyoujihuaEntity discusslvyoujihua = discusslvyoujihuaService.selectOne(new EntityWrapper<DiscusslvyoujihuaEntity>().eq("", username));
        return R.ok().put("data", discusslvyoujihua);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusslvyoujihuaEntity discusslvyoujihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusslvyoujihua);
        discusslvyoujihuaService.updateById(discusslvyoujihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusslvyoujihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusslvyoujihuaEntity discusslvyoujihua, HttpServletRequest request,String pre){
        EntityWrapper<DiscusslvyoujihuaEntity> ew = new EntityWrapper<DiscusslvyoujihuaEntity>();
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
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discusslvyoujihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusslvyoujihua), params), params));
        return R.ok().put("data", page);
    }










}
