package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingdianmenpiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingdianmenpiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingdianmenpiaoView;


/**
 * 景点门票
 *
 * @author 
 * @email 
 * @date 2024-04-21 22:55:48
 */
public interface JingdianmenpiaoService extends IService<JingdianmenpiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingdianmenpiaoVO> selectListVO(Wrapper<JingdianmenpiaoEntity> wrapper);
   	
   	JingdianmenpiaoVO selectVO(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);
   	
   	List<JingdianmenpiaoView> selectListView(Wrapper<JingdianmenpiaoEntity> wrapper);
   	
   	JingdianmenpiaoView selectView(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingdianmenpiaoEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JingdianmenpiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JingdianmenpiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JingdianmenpiaoEntity> wrapper);



}

