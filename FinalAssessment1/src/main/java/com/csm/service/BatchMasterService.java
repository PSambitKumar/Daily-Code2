package com.csm.service;

import java.util.List;

import com.csm.bean.BatchMasterDto;

public interface BatchMasterService {

	String saveBatchMaster(BatchMasterDto dto);

	List<BatchMasterDto> getAllBatchMaster();
	
}
