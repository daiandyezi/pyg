package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController 
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	@RequestMapping("/findAll.do")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}

	/**
	 * 商品管理 分页显示
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/findPage.do")
	public PageResult findPage(int page,int size) {

		return brandService.findPage(page,size);
	}

	/**
	 * 增加商品
	 * @param brand
	 */
	@RequestMapping("/add.do")
	public Result add(@RequestBody TbBrand brand) {

		try {
			brandService.add(brand);
			return new Result(true,"新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "新增失败");
		}

	}

	/**
	 * 查询单个
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
	 	return brandService.findOne(id);
	}

	/**
	 * 增加商品
	 * @param brand
	 */
	@RequestMapping("/update.do")
	public Result update(@RequestBody TbBrand brand) {

		try {
			brandService.update(brand);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}

	}
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			brandService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	/**
	 * 搜索
	 * @param brand
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand,int page,int size) {
		return brandService.findPage(brand, page, size);
	}

	/**
	 * 返回品牌的json数据
	 * @return
	 */
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return brandService.selectOptionList();
	}
}
