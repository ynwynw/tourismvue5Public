package com.dao;

import com.entity.ShengfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShengfenVO;
import com.entity.view.ShengfenView;


/**
 * 省份
 * 
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface ShengfenDao extends BaseMapper<ShengfenEntity> {
	
	List<ShengfenVO> selectListVO(@Param("ew") Wrapper<ShengfenEntity> wrapper);
	
	ShengfenVO selectVO(@Param("ew") Wrapper<ShengfenEntity> wrapper);
	
	List<ShengfenView> selectListView(@Param("ew") Wrapper<ShengfenEntity> wrapper);

	List<ShengfenView> selectListView(Pagination page,@Param("ew") Wrapper<ShengfenEntity> wrapper);

	
	ShengfenView selectView(@Param("ew") Wrapper<ShengfenEntity> wrapper);
	

}
