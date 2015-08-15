package com.memory.base.persistence;

import org.springframework.jdbc.core.JdbcTemplate;

public interface JdbcTemplateDao {
  
  void setJdbcTemplate(JdbcTemplate paramJdbcTemplate);
}
