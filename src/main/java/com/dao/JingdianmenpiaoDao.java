package com.dao;

import com.entity.JingdianmenpiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingdianmenpiaoVO;
import com.entity.view.JingdianmenpiaoView;


/**
 * 景点门票
 * 
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface JingdianmenpiaoDao extends BaseMapper<JingdianmenpiaoEntity> {
	
	List<JingdianmenpiaoVO> selectListVO(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);
	
	JingdianmenpiaoVO selectVO(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);
	
	List<JingdianmenpiaoView> selectListView(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);

	List<JingdianmenpiaoView> selectListView(Pagination page,@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);

	
	JingdianmenpiaoView selectView(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);



}
