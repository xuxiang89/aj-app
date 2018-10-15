package com.anjian.app.common;

import com.anjian.app.entity.SysDeptEntity;
import com.anjian.app.entity.SysUserEntity;
import com.anjian.app.service.SysDeptService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * page转换工具
 *
 * @author LiCheng
 * @data 2018.3.10
 */
@SuppressWarnings("all")
public class UtilPage {

    private static final Logger logger = LoggerFactory.getLogger(UtilPage.class);

    public static final String OR = "or";
    public static final String AND = "and";


    private UtilPage() {
    }

    /**
     * mybatisplus的page对象转换页面显示的page对象
     *
     * @param page
     * @param service
     * @param ew
     * @return
     */
    public static PageUtils getPageUtils(Page page, IService service, Wrapper ew) {
        SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        //进行查询
        Page<?> dataPage = service.selectPage(page, ew);
        //获取参数
        List<?> records = dataPage.getRecords();
        long total = dataPage.getTotal();
        long size = dataPage.getSize();
        int current = dataPage.getCurrent();
        //转换返回对象
        return new PageUtils(records, total, size, current);

    }

    /**
     * 分页：可根据部门过滤数据[OR]
     * @param page
     * @param service
     * @param ew
     * @param filtByDeptFlag
     * @return
     */
//    public static PageUtils getPageUtils(Page page, IService service, Wrapper ew, boolean filtByDeptFlag){
//        return getPageUtils(page,service,ew,filtByDeptFlag,OR,null);
//    }

    /**
     * 分页：可根据部门过滤数据[AND]
     * @param page
     * @param service
     * @param ew
     * @param filtByDeptFlag
     * @param deptIdStrWithSeparator 部门id字符串,并用[,]分隔符分割
     * @return
     */
    public static PageUtils getPageUtils(Page page, IService service, Wrapper ew, boolean filtByDeptFlag,String deptIdStrWithSeparator){
        return getPageUtils(page,service,ew,filtByDeptFlag,AND,deptIdStrWithSeparator);
    }

    /**
     * 分页：可根据部门过滤数据[OR/AND]
     * @param page
     * @param service
     * @param ew
     * @param filtByDeptFlag
     * @return
     */
    public static PageUtils getPageUtils(Page page, IService service, Wrapper ew, boolean filtByDeptFlag,String conditionType,String deptIdStrWithSeparator) {
        SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        //filte by dept
        if (UtilValidate.isEmpty(deptIdStrWithSeparator)) {
            deptIdStrWithSeparator = StringUtils.join(user.getDeptIdList(), ",");
        }
        if (filtByDeptFlag) {
            if (OR.equalsIgnoreCase(conditionType))
                ew.or(" FIND_IN_SET(dept_id,{0})", deptIdStrWithSeparator);
            else
                ew.and(" FIND_IN_SET(dept_id,{0})", deptIdStrWithSeparator);
        }
        //进行查询
        Page<?> dataPage = service.selectPage(page, ew);
        //获取参数
        List<?> records = dataPage.getRecords();
        long total = dataPage.getTotal();
        long size = dataPage.getSize();
        int current = dataPage.getCurrent();
        //转换返回对象
        return new PageUtils(records, total, size, current);
    }

    /**
     * 根据部门过滤数据，封装返回EntityWrapper
     * @param ew
     * @return
     */
    public static Wrapper filtByDept4EW(Wrapper<?> ew) {
        if (ew != null) {
            ew.addFilterIfNeed(true, getFiltByDeptSql(null));
        }
        return ew;
    }

    /**
     * 获取部门筛选的条件字符串
     * @param tableAlias 表别名
     * @return
     */
    public static String getFiltByDeptSql(String tableAlias) {
        //获取表的别名
        if(UtilValidate.isNotEmpty(tableAlias)){
            tableAlias +=  ".";
        }else{
            tableAlias = "";
        }
        SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        StringBuffer sql = new StringBuffer();
        sql.append(tableAlias).append(" FIND_IN_SET(dept_id,").append(StringUtils.join(user.getDeptIdList(), ",")).append(")");
        return sql.toString();
    }

    /**
     * 转换实体参数为map,支持添加部门过滤参数
     * @param entityObj
     * @param filtByDeptFlag 是否需要根据部门过滤数据
     * @return
     */
    public static Map<String,Object> wrapperEntitpParam2Map(Object entityObj,String tableAlias, boolean filtByDeptFlag) {
        Map<String, Object> params = null;
        try {
            params = BeanUtil.transBean2Map(entityObj);
            if (filtByDeptFlag) {
                params.put(Constant.SQL_FILTER, getFiltByDeptSqlDeptIn(tableAlias));
            }else{
                params.put(Constant.SQL_FILTER, getFiltByUserDept(tableAlias));
            }
        } catch (Exception e) {
            logger.error("实体转换异常！",e);
        }
        return params;
    }

    /**
     * 获取部门筛选的条件字符串
     * @param tableAlias 表别名
     * @return
     */
    public static String getFiltByDeptSqlDeptIn(String tableAlias) {
        //获取表的别名
        if(UtilValidate.isNotEmpty(tableAlias)){
            tableAlias +=  ".";
        }else{
            tableAlias = "";
        }
        SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        StringBuffer sql = new StringBuffer();
        sql.append(tableAlias).append("dept_id in (").append(StringUtils.join(user.getDeptIdList(), ",")).append(")");
        return sql.toString();
    }

    /**
     * 获取当前登录人所在部门的六位最大部门以及子集
     * @param tableAlias 表别名
     * @return
     */
    public static String getFiltByUserDept(String tableAlias) {
        //获取表的别名
        if(UtilValidate.isNotEmpty(tableAlias)){
            tableAlias +=  ".";
        }else{
            tableAlias = "";
        }
        SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        StringBuffer sql = new StringBuffer();
        SysDeptService sysDeptService= (SysDeptService)SpringContextUtils.getBean("sysDeptService");
        SysDeptEntity deptEntity=sysDeptService.selectById(user.getDeptId());
        if(UtilValidate.isNotEmpty(deptEntity)){
            String deptCode=deptEntity.getDeptCode();
            if(UtilValidate.isNotEmpty(deptCode)&&deptCode.length()>=6){
                deptCode=deptCode.substring(0,6);
            }
            List<SysDeptEntity> deptEntities= sysDeptService.selectList(new EntityWrapper<SysDeptEntity>().andNew("dept_code like {0}",deptCode+"%").setSqlSelect("dept_id"));
            StringBuffer sb=new StringBuffer("");
            for(SysDeptEntity s:deptEntities){
                sb.append(s.getDeptId()).append(",");
            }
            if(UtilValidate.isNotEmpty(sb)){
                sb.deleteCharAt(sb.length() - 1);
            }
            sql.append(tableAlias).append("dept_id in (").append(sb.toString()).append(")");
        }

        return sql.toString();
    }
}
