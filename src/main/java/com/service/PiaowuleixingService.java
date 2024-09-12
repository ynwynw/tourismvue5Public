package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PiaowuleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PiaowuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PiaowuleixingView;


/**
 * 票务类型
 *
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface PiaowuleixingService extends IService<PiaowuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PiaowuleixingVO> selectListVO(Wrapper<PiaowuleixingEntity> wrapper);
   	
   	PiaowuleixingVO selectVO(@Param("ew") Wrapper<PiaowuleixingEntity> wrapper);
   	
   	List<PiaowuleixingView> selectListView(Wrapper<PiaowuleixingEntity> wrapper);
   	
   	PiaowuleixingView selectView(@Param("ew") Wrapper<PiaowuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PiaowuleixingEntity> wrapper);

   	

}

