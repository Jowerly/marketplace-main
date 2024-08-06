package com.groupproyect.marketplace.service.cite;

import com.groupproyect.marketplace.model.cite.Department;
import com.groupproyect.marketplace.repository.cite.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends BaseCiteService<Department> {
  @SuppressWarnings("unused")
  private DepartmentRepository departmentRepository;

  public DepartmentService(DepartmentRepository departmentRepository) {
    super(departmentRepository);
    this.departmentRepository = departmentRepository;
  }
}
