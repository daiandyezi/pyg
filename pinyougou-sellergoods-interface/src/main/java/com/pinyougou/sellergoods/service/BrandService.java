package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

/**
 * 品牌接口
 * @author 13191
 *
 */
public interface BrandService {


	public List<TbBrand> findAll();

	/**
	 * 品牌管理
	 * @param pagNum 当前页面
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(int pagNum,int pageSize);

	/**
	 * 增加
	 * @param brand
	 */
	public void add(TbBrand brand);

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);

	/**
	 * 修改
	 * @param brand
	 */
	public void update(TbBrand brand);

	/**
	 * 删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 搜索分页
	 * @param brand
	 * @param pagNum
	 * @param pageSize
	 * @return
	 */
	public PageResult findPage(TbBrand brand,int pagNum,int pageSize);

	/**
	 * 返回下拉列表数据
	 * @return
	 */
	public List<Map> selectOptionList();
}
