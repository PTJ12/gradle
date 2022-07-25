package cn.ut.gradle.service.impl;

import cn.ut.gradle.entity.SysAdmin;
import cn.ut.gradle.mapper.SysAdminMapper;
import cn.ut.gradle.service.SysAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author PuTongjiao
 * @date 2022/7/25 23:04
 */
@Service
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, SysAdmin> implements SysAdminService {
}
