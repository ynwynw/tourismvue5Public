package com.dao;

import com.entity.PiaowuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PiaowuleixingVO;
import com.entity.view.PiaowuleixingView;


/**
 * 票务类型
 * 
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface PiaowuleixingDao extends BaseMapper<PiaowuleixingEntity> {
	
	List<PiaowuleixingVO> selectListVO(@Param("ew") Wrapper<PiaowuleixingEntity> wrapper);
	
	PiaowuleixingVO selectVO(@Param("ew") Wrapper<PiaowuleixingEntity> wrapper);
	
	List<PiaowuleixingView> selectListView(@Param("ew") Wrapper<PiaowuleixingEntity> wrapper);

	List<PiaowuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<PiaowuleixingEntity> wrapper);

	
	PiaowuleixingView selectView(@Param("ew") Wrapper<PiaowuleixingEntity> wrapper);
	

}
