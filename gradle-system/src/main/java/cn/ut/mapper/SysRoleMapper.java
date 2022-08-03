package cn.ut.mapper;


import cn.ut.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author ut
 * @since 2022-07-30
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<SysRole> getRoles(Long adminId);
}
