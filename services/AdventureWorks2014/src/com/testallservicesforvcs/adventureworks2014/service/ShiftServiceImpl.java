/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testallservicesforvcs.adventureworks2014.EmployeeDepartmentHistory;
import com.testallservicesforvcs.adventureworks2014.Shift;


/**
 * ServiceImpl object for domain model class Shift.
 *
 * @see Shift
 */
@Service("AdventureWorks2014.ShiftService")
@Validated
public class ShiftServiceImpl implements ShiftService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiftServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("AdventureWorks2014.EmployeeDepartmentHistoryService")
	private EmployeeDepartmentHistoryService employeeDepartmentHistoryService;

    @Autowired
    @Qualifier("AdventureWorks2014.ShiftDao")
    private WMGenericDao<Shift, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Shift, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
    @Override
	public Shift create(Shift shift) {
        LOGGER.debug("Creating a new Shift with information: {}", shift);
        return this.wmGenericDao.create(shift);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Shift getById(Short shiftIdInstance) throws EntityNotFoundException {
        LOGGER.debug("Finding Shift by id: {}", shiftIdInstance);
        Shift shift = this.wmGenericDao.findById(shiftIdInstance);
        if (shift == null){
            LOGGER.debug("No Shift found with id: {}", shiftIdInstance);
            throw new EntityNotFoundException(String.valueOf(shiftIdInstance));
        }
        return shift;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Shift findById(Short shiftIdInstance) {
        LOGGER.debug("Finding Shift by id: {}", shiftIdInstance);
        return this.wmGenericDao.findById(shiftIdInstance);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Shift getByStartTimeAndEndTime(Time startTime, Time endTime) {
        Map<String, Object> startTimeAndEndTimeMap = new HashMap<>();
        startTimeAndEndTimeMap.put("startTime", startTime);
        startTimeAndEndTimeMap.put("endTime", endTime);

        LOGGER.debug("Finding Shift by unique keys: {}", startTimeAndEndTimeMap);
        Shift shift = this.wmGenericDao.findByUniqueKey(startTimeAndEndTimeMap);

        if (shift == null){
            LOGGER.debug("No Shift found with given unique key values: {}", startTimeAndEndTimeMap);
            throw new EntityNotFoundException(String.valueOf(startTimeAndEndTimeMap));
        }

        return shift;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Shift getByName(String name) {
        Map<String, Object> nameMap = new HashMap<>();
        nameMap.put("name", name);

        LOGGER.debug("Finding Shift by unique keys: {}", nameMap);
        Shift shift = this.wmGenericDao.findByUniqueKey(nameMap);

        if (shift == null){
            LOGGER.debug("No Shift found with given unique key values: {}", nameMap);
            throw new EntityNotFoundException(String.valueOf(nameMap));
        }

        return shift;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "AdventureWorks2014TransactionManager")
	@Override
	public Shift update(Shift shift) throws EntityNotFoundException {
        LOGGER.debug("Updating Shift with information: {}", shift);

        if(shift.getEmployeeDepartmentHistories() != null) {
            for(EmployeeDepartmentHistory _employeeDepartmentHistory : shift.getEmployeeDepartmentHistories()) {
                _employeeDepartmentHistory.setShift(shift);
            }
        }

        this.wmGenericDao.update(shift);

        Short shiftIdInstance = shift.getShiftId();

        return this.wmGenericDao.findById(shiftIdInstance);
    }

    @Transactional(value = "AdventureWorks2014TransactionManager")
	@Override
	public Shift delete(Short shiftIdInstance) throws EntityNotFoundException {
        LOGGER.debug("Deleting Shift with id: {}", shiftIdInstance);
        Shift deleted = this.wmGenericDao.findById(shiftIdInstance);
        if (deleted == null) {
            LOGGER.debug("No Shift found with id: {}", shiftIdInstance);
            throw new EntityNotFoundException(String.valueOf(shiftIdInstance));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<Shift> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Shifts");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<Shift> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Shifts");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table Shift to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<EmployeeDepartmentHistory> findAssociatedEmployeeDepartmentHistories(Short shiftId, Pageable pageable) {
        LOGGER.debug("Fetching all associated employeeDepartmentHistories");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("shift.shiftId = '" + shiftId + "'");

        return employeeDepartmentHistoryService.findAll(queryBuilder.toString(), pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeDepartmentHistoryService instance
	 */
	protected void setEmployeeDepartmentHistoryService(EmployeeDepartmentHistoryService service) {
        this.employeeDepartmentHistoryService = service;
    }

}

