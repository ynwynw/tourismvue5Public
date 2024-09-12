package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslvyoujihuaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslvyoujihuaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslvyoujihuaView;


/**
 * 旅游计划评论表
 *
 * @author 
 * @email 
 * @date 2024-04-21 22:55:49
 */
public interface DiscusslvyoujihuaService extends IService<DiscusslvyoujihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslvyoujihuaVO> selectListVO(Wrapper<DiscusslvyoujihuaEntity> wrapper);
   	
   	DiscusslvyoujihuaVO selectVO(@Param("ew") Wrapper<DiscusslvyoujihuaEntity> wrapper);
   	
   	List<DiscusslvyoujihuaView> selectListView(Wrapper<DiscusslvyoujihuaEntity> wrapper);
   	
   	DiscusslvyoujihuaView selectView(@Param("ew") Wrapper<DiscusslvyoujihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslvyoujihuaEntity> wrapper);

   	

}

