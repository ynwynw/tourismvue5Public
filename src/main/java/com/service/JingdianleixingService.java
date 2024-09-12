package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingdianleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingdianleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingdianleixingView;


/**
 * 景点类型
 *
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface JingdianleixingService extends IService<JingdianleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingdianleixingVO> selectListVO(Wrapper<JingdianleixingEntity> wrapper);
   	
   	JingdianleixingVO selectVO(@Param("ew") Wrapper<JingdianleixingEntity> wrapper);
   	
   	List<JingdianleixingView> selectListView(Wrapper<JingdianleixingEntity> wrapper);
   	
   	JingdianleixingView selectView(@Param("ew") Wrapper<JingdianleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingdianleixingEntity> wrapper);

   	

}

