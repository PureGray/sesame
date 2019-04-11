package org.sesame.service.impl.provider;

import org.sesame.service.interfaces.MachineIdProvider;
import org.sesame.service.util.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbMachineIdProvider implements MachineIdProvider {
	private static final Logger log = LoggerFactory.getLogger(DbMachineIdProvider.class);

	private long machineId;
	private JdbcTemplate jdbcTemplate;
	private ComboPooledDataSource comboPooledDataSource;

	public void setMachineId(long machineId) {
		this.machineId = machineId;
	}

	public void setComboPooledDataSource(ComboPooledDataSource comboPooledDataSource) {
		this.comboPooledDataSource = comboPooledDataSource;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	DbMachineIdProvider() {
		log.debug("DbMachineIdProvider is constructed ...");
	}

	public void init() {
		String ip = IpUtil.getHostIp();

		if (StringUtils.isEmpty(ip)) {
			log.error("Failed to get ip, DbMachineIdProvider stop initialing ...");

			throw new IllegalStateException("Failed to get ip");
		}

		log.debug("This instance ip is {}", ip);

		Long id = null;

		try {
			id = jdbcTemplate.queryForObject("select ID from DB_MACHINE_ID_PROVIDER where IP = ?", new Object[] { ip },
					Long.class);
		} catch (EmptyResultDataAccessException e) {
			log.error("No allocation before for ip {}.", ip);
		}

		if (null != id) {
			machineId = id;
			return;
		}

		log.info("Fail to get ID from DB for host IP address {}. Next step try to allocate one.", ip);

		int count = jdbcTemplate.update("update DB_MACHINE_ID_PROVIDER set IP = ? where IP is null limit 1", ip);
		
		if (count <= 0 || count > 1) {
            String msg = String
                    .format("Fail to allocte ID for host IP address {}. The {} records are updated. Stop to initialize the DbMachineIdProvider provider.",
                            ip, count);

            log.error(msg);
            throw new IllegalStateException(msg);
        }
		
		try {
            id = jdbcTemplate.queryForObject(
                    "select ID from DB_MACHINE_ID_PROVIDER where IP = ?",
                    new Object[]{ip}, Long.class);

        } catch (EmptyResultDataAccessException e) {
            // Ignore the exception
            log.error("Fail to do allocation for ip {}.", ip);
        }

        if (id == null) {
            String msg = String
                    .format("Fail to get ID from DB for host IP address {} after allocation. Stop to initialize the DbMachineIdProvider provider.",
                            ip);

            log.error(msg);
            throw new IllegalStateException(msg);
        }
        
        machineId = id;

	}

	public long getMachineId() {
		
		return machineId;
	}

}
