package com.pinyougou.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
/**
 * 认证类,用于写方法,读取数据库数据
 * @author 13191
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {


    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }



    /**
     * 用户在登录页面输入用户名登录时就会执行该方法
     * grantAuths:用户角色集合
     * User(username, "123456", grantAuths):"123456"为正确的用户密码,
     * 框架会用该返回的user和登录页面输入的密码对比,grantAuths表示该用户拥有的角色,宽街会开放角色的权限(访问路径)
     *
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        System.out.println("经过了UserDetailsServiceImpl");

        //构建角色列表,当前角色只有一个ROLE_SELLER
        List<GrantedAuthority> grantAuths = new ArrayList<GrantedAuthority>();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        //得到商家对象
        TbSeller seller = sellerService.findOne(username);
        if (seller!=null) {
            if (seller.getStatus().equals("1")) {
                return new User(username, seller.getPassword(), grantAuths);//用户名或密码错误时返回null
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

}
