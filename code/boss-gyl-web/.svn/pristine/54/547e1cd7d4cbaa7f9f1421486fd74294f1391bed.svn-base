/**
 * 计算费用
 * @author 汪玮琦
 * @since 2017.12.23
 * @returns
 */

define(['ajax', 'util'], function (ajax, util) {
	// 合同信息
	var contractInfo
	// 手续费率数组
	var serviceFeeRate
	// 保证金账户
	var depositAccount
	// 开票费基数
	var invoiceBaseFee
	// 总重量
	var totalGoodsWeight
	// 总金额
	var totalGoodsPayment
	/**
	 * 合同打款记录
	 */
	var contractRemit
	var day = 24 * 60 * 60 * 1000
	
	
	/**
	 * 用于当天时间相比较
	 */
	function dateDiff(date) {
		var date1 = new Date(formatDate(date))
		var date2 = new Date(formatDate())
		var diffMillseconds = date2.getTime() - date1.getTime()
		return Math.floor(diffMillseconds / day) + 1
	}
	
	function formatDate(date) {
		var resDate
		if (date) {
			resDate = new Date(date)
		} else {
			resDate = new Date()
		}
		return resDate.getFullYear() + '-' + (resDate.getMonth() + 1) + '-' + resDate.getDate()
	}
	
	/**
	 * 获取合同
	 */
	function getContractInfo(contractId) {
		return new Promise(function (resolve, reject) {
			ajax.findOne('/contract', contractId).then(function (res) {
				if (res.state === 1) {
					contractInfo = res.data
					invoiceBaseFee = res.data['invoiceBaseFee']
					serviceFeeRate = res.data['feeRates']
					resolve()
				}
			}, function () {
				reject()
			})
		})
	}
	
	/**
	 * 合同打款记录
	 */
	function getContractRemit(contractId) {
		return new Promise(function (resolve, reject) {
			ajax.get('/instockBill/findContractRecord', {contractId:contractId}).then(function (res) {
				if (res.state === 1) {
					contractRemit = res.data
					resolve()
				}
			}, function () {
				reject()
			})
		})
	}
	
	/**
	 * 获取保证金账号
	 */
	function getDepositAccount(contractId) {
		return new Promise(function (resolve, reject) {
			ajax.get('/deposit/findOneByContractId', {contractId:contractId}).then(function (res) {
				if (res.state === 1) {
					depositAccount = res.data
					resolve()
				}
			}, function () {
				reject()
			})
		})
	}
	
	/**
	 * 计算开票费
	 */
	function computedInvoiceFee (goodsList, invoiceBaseFee) {
		var totalInvoiceFee = 0
		goodsList.forEach(function (item, index, array) {
			var invoiceFee = 0
			if (dateDiff(item['instockDate']) <= 15) {
				invoiceFee = item['redWeight'] / 1000 * invoiceBaseFee
			}
			item['invoiceFee'] = util.formatNumber(invoiceFee, 2)
			totalInvoiceFee += invoiceFee
		})
		return util.formatNumber(totalInvoiceFee, 2)
	}
	
	/**
	 * 计算手续费
	 */
	function computedServiceFeeDetail (contractRemit, goodsList, serviceFeeRate) {
		var totalServiceFee = 0
		goodsList.forEach(function (item, index, array) {
//			var goodsMoney = item.invInventory['contractMoney'] / item.invInventory['quantity'] * item.redRedeemDetail['amount']
			var goodsMoney = item.contractUnitPrice * item.amount
			var serviceFee = computedRemit(contractRemit, goodsMoney, serviceFeeRate)
			item.serviceFee = util.formatNumber(serviceFee, 2)
			totalServiceFee += serviceFee
		})
		return util.formatNumber(totalServiceFee, 2)
	}
	
	/**
	 * 手续费 = 货款 * 手续费率 * 天数
	 * 如果 合同打款记录(一天的) - 货款 != 负数 (就是说钱够) 的情况 
	 * 	  就是  货款 * 是续费率 * 天数
	 * else 
	 * 	  合同打款记录(一天的) - 货款 == 负数 (就是说钱不够) 的情况 
	 *    货款 * 手续费率 * 第一天天数 + 剩余的货款 * 手续费率 * 第二天天数
	 *    第二天的合同打款记录 应相应减少
	 */
	/**
	 * @params contractRemit 合同打款记录 数组
	 * @params goodsFee	货款	
	 * @params serviceFeeRate 手续费率列表
	 */
	function computedRemit (contractRemit, goodsFee, serviceFeeRate) {
		var resultFee = 0
		var contractRemitTemp = $.extend(true, [], contractRemit)
		// 计算 本条货款距离今天的时间
		var diffDay = 0
		if (contractRemitTemp[0] && contractRemitTemp[0].detail['remitDate']) {
			diffDay = dateDiff(contractRemitTemp[0].detail['remitDate'])
		}
		if (contractRemitTemp[0].detail['balance'] - goodsFee == 0) { // 打款记录中的货款   与  实际货款    相减为零 即正好用完
			// 计算
			resultFee = computedServiceFee(goodsFee, diffDay, serviceFeeRate)
			// 将用完的合同打款记录从源数组中移除
			contractRemitTemp.splice(0, 1)
		} else if (contractRemitTemp[0].detail['balance'] - goodsFee > 0) { // 打款记录中的货款   与  实际货款    相减为正数时 即 货款比打款记录少，打款记录有富裕
			// 计算
			resultFee = computedServiceFee(goodsFee, diffDay, serviceFeeRate)
			// 将货款金额从合同打款记录中减去
			contractRemitTemp[0].detail['balance'] -= goodsFee
		} else { // 打款记录中的货款    与    实际货款   相减为负数 即 货款比一条打款记录多时，需要使用下一条打款记录中的货款
			// 将第一条打款记录中的货款全部用了
			var firstStepFee = computedServiceFee(contractRemitTemp[0].detail['balance'], diffDay, serviceFeeRate)
			// 计算出还需要多少货款
			var balanceFee = goodsFee - contractRemitTemp[0].detail['balance']
			// 使用下一条打款记录中的货款
			var secondStepFee = 0
			// 先判断下一条打款记录是否存在
			if (contractRemitTemp[1] && contractRemitTemp[1].detail['balance']) {
				var nextDiffDay = 0
				if (contractRemitTemp[1] && contractRemitTemp[1].detail['remitDate']) {
					nextDiffDay = dateDiff(contractRemitTemp[1].detail['remitDate'])
				}
				secondStepFee = computedServiceFee(balanceFee, nextDiffDay, serviceFeeRate)
				contractRemitTemp[1].detail['balance'] -= balanceFee
				// 将用完的打款记录货款从源数据组中移除
				contractRemitTemp.splice(0, 1)
			}
			resultFee = firstStepFee + secondStepFee
		}
		return resultFee
	}
	
	/**
	 * 计算保证金
	 * @params goodsList 货物列表
	 * @params contractInfo	合同信息	
	 * @params depositAccount 保证金账户
	 */
	function computedDeposit (goodsList, contractInfo, depositAccount, isLastGoods) {
		if (depositAccount) {
			if (isLastGoods) {
				return depositAccount['depositFee']
			} else {
				return totalGoodsPayment / contractInfo['totalMoney'] * depositAccount['depositFee']
			}
		} else {
			return 0
		}
	}
	
	/**
	 * 总货款
	 * @params goodsList 货物列表
	 */
	function computedTotalGoodsPayment (goodList) {
		totalGoodsPayment = 0;
		if (goodList) {
			goodList.forEach(function (item, index) {
//				totalGoodsPayment += item.invInventory['contractMoney'] / item.invInventory['quantity'] * item.redRedeemDetail['amount']
//				totalGoodsPayment += item.contractUnitPrice * item.amount
				totalGoodsPayment += item.contractUnitPrice * item.redWeight / item.baseProduct.unitRate
			})
		}
		return totalGoodsPayment
	}
	/**
	 * 计算总重量
	 */
	function computedTotalWeight (goodsList) {
		totalGoodsWeight = 0
		goodsList.forEach(function (item, index, array) {
			totalGoodsWeight += item.amount * item.counterpoise
		})
	}
	
	/**
	 * 计算手续费率
	 * @params goodsFee 货款
	 * @params dateDiff 距离今天的天数
	 * @params feeRates 合同对应的手续费率
	 */
	function computedServiceFee(goodsFee, dateDiff, feeRates) {
		var serviceFee = 0
		var dateDiffTemp = dateDiff == 0 ? 1 : dateDiff
		var feeRatesTemp = $.extend(true, [], feeRates)
		if (feeRatesTemp && feeRatesTemp.length > 0) {
			feeRatesTemp.forEach(function(item, index) {
				if (dateDiffTemp > 0) {
					/**
					 * 当天数小于设定的日期时
					 * 直接使用此天数
					 * 并且将天数减去，此时天数应为负数，下次就不会进入判断了。。
					 * 将此手续费率移除
					 */
					if (dateDiffTemp <= item['feeDates']) {
						serviceFee += goodsFee * dateDiffTemp * item['feeValue']
						dateDiffTemp -= item['feeDates']
						feeRatesTemp.splice(0, 1)
					} else {
						serviceFee += goodsFee * item['feeDates'] * item['feeValue']
						dateDiffTemp -= item['feeDates']
					}
				}
			})
		}
		return serviceFee
	}
	
	/**
	 * 计算 赎货款 和 赎货重量
	 */
	function computedSinglePaymentAndQuantity(goodsList, needFee) {
		if (goodsList) {
			goodsList.forEach(function(item, index, array) {
				item.redWeight = item.amount * item['counterpoise']
				if (needFee) {
//					item.redRedeemDetail['redeemMoney'] = item.invInventory['contractMoney'] / item.invInventory['quantity'] * item.redRedeemDetail['amount']
//					item.redeemMoney = item.contractUnitPrice * item.amount
					item.redeemMoney = item.contractUnitPrice * item.redWeight / item.baseProduct.unitRate
					item.redeemMoney = item.redeemMoney.toFixed(3)
				}
				
			})
		}
	}
	
	/**
	 * 生成返回结果
	 */
	function generalResult (goodsList, depositFee, needFee, isLastGoods) {
		var totalMoney = 0
		var totalInvoiceFee = 0
		var totalGoodsPayment = 0
		var totalServiceFee = 0
		var realMoney = 0
		var depositFeeMax = 0
		computedTotalWeight(goodsList)
		computedSinglePaymentAndQuantity(goodsList, needFee)
		if (needFee) {
			// 总开票费
			totalInvoiceFee = computedInvoiceFee(goodsList, contractInfo['invoiceBaseFee'])
			// 总货款
			totalGoodsPayment = computedTotalGoodsPayment(goodsList)
			// 总手续费
//		var totalServiceFee = computedRemit(contractRemit, totalGoodsPayment, serviceFeeRate)
			// 如果有保证金的话
			computedServiceFeeDetail (contractRemit, goodsList, serviceFeeRate)
			totalServiceFee = computedRemit(contractRemit, totalGoodsPayment - depositFee, serviceFeeRate)
			// 判断 手续费是否小于零
			totalServiceFee = totalServiceFee<0? 0:totalServiceFee
			// 总金额
			totalMoney = totalInvoiceFee + totalServiceFee + totalGoodsPayment
			// 待付总金额
			realMoney = totalMoney - depositFee
			// 最大保证金
			depositFeeMax = computedDeposit(goodsList, contractInfo, depositAccount, isLastGoods)
		}
		return {
			// 货物列表
			list: goodsList,
			// 总重量
			totalWeight: util.formatNumber((totalGoodsWeight / 1000), 3),
			// 总开票费
			totalInvoiceFee: util.formatNumber(totalInvoiceFee, 2),
			// 总手续费
			totalServiceFee: util.formatNumber(totalServiceFee, 2),
			// 保证金
			depositFee: util.formatNumber(depositFeeMax, 0, 'ceil'),
			// 总货款
			totalGoodsPayment: util.formatNumber(totalGoodsPayment,2),
			// 总金额
			totalMoney: util.formatNumber(totalMoney, 2),
			// 代付总金额
			realMoney: util.formatNumber(realMoney, 2)
		}
	}
	
	return {
		
		computedFee: function (goodsList, contractId, depositFee, needFee, isLastGoods) {
			var promises = []
			if (contractInfo == null) {
				promises.push(getContractInfo(contractId))
			}
			if (!isLastGoods && depositAccount == null) {
				promises.push(getDepositAccount(contractId))
			} else if (isLastGoods) {
				depositAccount = {
					depositFee: depositFee
				}
			}
			if (contractRemit == null) {
				promises.push(getContractRemit(contractId))
			}
			return new Promise(function (resolve, reject) {
				if (promises.length > 0) {
					var all = Promise.all(promises)
					all.then(function (res) {
						resolve(generalResult(goodsList, depositFee, needFee, isLastGoods))
					})
				} else {
					resolve(generalResult(goodsList, depositFee, needFee, isLastGoods))
				}
			})
		},
		computedFeeTest: function (goodsList, contractInfo, depositAccount, contractRemit, isLastGoods) {
			var totalInvoiceFee = computedInvoiceFee(goodsList, contractInfo['invoiceBaseFee'])
			var totalServiceFee = computedServiceFee(contractRemit, goodsList, contractInfo)
			var depositFee = computedDeposit(goodsList, contractInfo, depositAccount, isLastGoods)
			return {
				// 货物列表
				list: goodsList,
				// 总开票费
				totalInvoiceFee: totalInvoiceFee,
				// 总手续费
				totalServiceFee: totalServiceFee,
				// 保障金
				depositFee: depositFee
			}
		}
	}
})