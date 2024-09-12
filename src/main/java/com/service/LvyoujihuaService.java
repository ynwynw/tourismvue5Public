package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LvyoujihuaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LvyoujihuaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LvyoujihuaView;


/**
 * 旅游计划
 *
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface LvyoujihuaService extends IService<LvyoujihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LvyoujihuaVO> selectListVO(Wrapper<LvyoujihuaEntity> wrapper);
   	
   	LvyoujihuaVO selectVO(@Param("ew") Wrapper<LvyoujihuaEntity> wrapper);
   	
   	List<LvyoujihuaView> selectListView(Wrapper<LvyoujihuaEntity> wrapper);
   	
   	LvyoujihuaView selectView(@Param("ew") Wrapper<LvyoujihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LvyoujihuaEntity> wrapper);

   	

}

