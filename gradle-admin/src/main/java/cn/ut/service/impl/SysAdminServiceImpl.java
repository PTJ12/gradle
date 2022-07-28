package cn.ut.service.impl;

import cn.ut.entity.SysAdmin;
import cn.ut.mapper.SysAdminMapper;
import cn.ut.service.SysAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author PuTongjiao
 * @date 2022/7/25 23:04
 */
@Service
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, SysAdmin> implements SysAdminService {
}
