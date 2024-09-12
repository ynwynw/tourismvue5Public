package com.dao;

import com.entity.JingdianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingdianxinxiVO;
import com.entity.view.JingdianxinxiView;


/**
 * 景点信息
 * 
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface JingdianxinxiDao extends BaseMapper<JingdianxinxiEntity> {
	
	List<JingdianxinxiVO> selectListVO(@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);
	
	JingdianxinxiVO selectVO(@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);
	
	List<JingdianxinxiView> selectListView(@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);

	List<JingdianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);

	
	JingdianxinxiView selectView(@Param("ew") Wrapper<JingdianxinxiEntity> wrapper);
	

}
