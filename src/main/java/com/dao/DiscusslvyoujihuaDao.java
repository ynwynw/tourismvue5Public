package com.dao;

import com.entity.DiscusslvyoujihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslvyoujihuaVO;
import com.entity.view.DiscusslvyoujihuaView;


/**
 * 旅游计划评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-21 22:55:49
 */
public interface DiscusslvyoujihuaDao extends BaseMapper<DiscusslvyoujihuaEntity> {
	
	List<DiscusslvyoujihuaVO> selectListVO(@Param("ew") Wrapper<DiscusslvyoujihuaEntity> wrapper);
	
	DiscusslvyoujihuaVO selectVO(@Param("ew") Wrapper<DiscusslvyoujihuaEntity> wrapper);
	
	List<DiscusslvyoujihuaView> selectListView(@Param("ew") Wrapper<DiscusslvyoujihuaEntity> wrapper);

	List<DiscusslvyoujihuaView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslvyoujihuaEntity> wrapper);

	
	DiscusslvyoujihuaView selectView(@Param("ew") Wrapper<DiscusslvyoujihuaEntity> wrapper);
	

}
