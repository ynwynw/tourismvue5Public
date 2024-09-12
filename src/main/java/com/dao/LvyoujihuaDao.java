package com.dao;

import com.entity.LvyoujihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LvyoujihuaVO;
import com.entity.view.LvyoujihuaView;


/**
 * 旅游计划
 * 
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface LvyoujihuaDao extends BaseMapper<LvyoujihuaEntity> {
	
	List<LvyoujihuaVO> selectListVO(@Param("ew") Wrapper<LvyoujihuaEntity> wrapper);
	
	LvyoujihuaVO selectVO(@Param("ew") Wrapper<LvyoujihuaEntity> wrapper);
	
	List<LvyoujihuaView> selectListView(@Param("ew") Wrapper<LvyoujihuaEntity> wrapper);

	List<LvyoujihuaView> selectListView(Pagination page,@Param("ew") Wrapper<LvyoujihuaEntity> wrapper);

	
	LvyoujihuaView selectView(@Param("ew") Wrapper<LvyoujihuaEntity> wrapper);
	

}
