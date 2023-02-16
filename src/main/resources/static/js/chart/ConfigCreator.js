function ConfigMaker() {

	var myChart;


	var option = {
			responsive: true,
		
			legend: {
				position: 'bottom',
			},
			tooltips: {
				mode: 'index',
				intersect: false,
				callbacks: {
					label: function(tooltipItem, chart){
						var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
						return datasetLabel  +" : " + number_format(tooltipItem.yLabel, 2);
					}
				}
			},
			hover: {
				mode: 'nearest',
				intersect: true
			},
			scales: {
				xAxes: [{
					scaleLabel: {
						display: true,
						labelString: 'Year'
					},
					ticks: {
		                padding: 10
		            }
				}],
				yAxes: [{
					scaleLabel: {
						display: true,
						labelString: 'Value'
					},
					ticks: {
						suggestedMin: 0,    // minimum will be 0, unless there is a lower value.
						// OR //
						beginAtZero: true,   // minimum value will be 0.
		                padding: 10,
						callback: function(value) {
							return number_format(value);
						}
		            }
				}]
			},


	};

	var optionNotZero = {
		responsive: true,

		legend: {
			position: 'bottom',
		},
		tooltips: {
			mode: 'index',
			intersect: false,
			callbacks: {
				label: function(tooltipItem, chart){
					var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
					return datasetLabel  +" : " + number_format(tooltipItem.yLabel, 2);
				}
			}
		},
		hover: {
			mode: 'nearest',
			intersect: true
		},
		scales: {
			xAxes: [{
				scaleLabel: {
					display: true,
					labelString: 'Year'
				},
				ticks: {
					padding: 10
				}
			}],
			yAxes: [{
				scaleLabel: {
					display: true,
					labelString: 'Value'
				},
				ticks: {
					padding: 10,
					callback: function(value) {
						return number_format(value);
					}
				}
			}]
		},


	};

	var radaroptions = {
		responsive: true,

		legend: {
			position: 'bottom',
		},
		tooltips: {
			mode: 'index',
			intersect: false,
			callbacks: {
				label: function(tooltipItem, chart){
					var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
					return datasetLabel  +" : " + number_format(tooltipItem.yLabel, 2);
				}
			}
		},
		hover: {
			mode: 'nearest',
			intersect: true
		},
		maintainAspectRatio: true,
		spanGaps: false,
		elements: {
			line: {
				tension: 0.000001
			}
		},
		plugins: {
			filler: {
				propagate: false
			},
			'samples-filler-analyser': {
				target: 'chart-analyser'
			}
		}
	};

	this.createRadarChartConfig = function(labels,datasets,fill) {
		var config = {
			type: 'radar',
			data:{
				labels: labels,
				datasets:[]
			},
			options: radaroptions
		}

		for(idx in datasets){
			var tmp = this.createRaderDataset(datasets[idx],fill);
			config.data.datasets.push(tmp);
		};


		return config;
	}

	this.createLineChartConfigNotZero = function(labels,datasets,fill,unit) {
		if(unit != undefined && unit != "") {
			optionNotZero.scales.yAxes[0].scaleLabel.labelString=unit;
		}
		var config = {
			type: 'line',
			data:{
				labels: labels,
				datasets:[]
			},
			options: optionNotZero
		}

		for(idx in datasets){
			var tmp = this.createDataset(datasets[idx],fill);
			config.data.datasets.push(tmp);
		};


		return config;
	}


	this.createLineChartConfig = function(labels,datasets,fill,unit) {
		if(unit != undefined && unit != "") {
			option.scales.yAxes[0].scaleLabel.labelString=unit;
		}
		var config = {
				type: 'line',
				data:{
					labels: labels,
					datasets:[]
				},
				options: option
		}
		
		for(idx in datasets){
			var tmp = this.createDataset(datasets[idx],fill);
			config.data.datasets.push(tmp);
		};
		
		
		return config;
	}


	this.createLineNLine = function(arrYear,barData,lineData) {

		var config  = {
			type: 'line',
			data: {
				labels  :arrYear,
				datasets: [
					{
						type: 'line',
						label               : lineData.title,
						borderColor : lineData.borderColor,
						backgroundColor: lineData.backgroundColor,
						data                : lineData.data,
						fill  : false,
						spanGaps: true,
						yAxisID: lineData.yaxis
					}
				]
			},
			options: {
				title: {
					display: true,
					position: 'top',
					text: lineData.title
				},
				responsive: true,
				legend: {
					position: 'bottom',
				},tooltips: {
					mode: 'index',
					intersect: false,
					callbacks: {
						label: function(tooltipItem, chart){
							var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
							return datasetLabel  +": "+ number_format(tooltipItem.yLabel, 2);
						}
					}
				},scales: {
					xAxes: [{
						scaleLabel: {
							display: true,
							labelString: 'Year'
						},
						ticks: {
							padding: 10
						}
					}],
					yAxes: [{
						type: 'linear',
						display: true,
						position: 'left',
						id: 'energy',
						scaleLabel: {
							display: true,
							labelString: '천TOE'
						},
						ticks: {
							min: 0,
							//suggestedMin: 0,    // minimum will be 0, unless there is a lower value.
							// OR //
							beginAtZero: true,   // minimum value will be 0.
								callback: function(value) {
								return number_format(value);
							}
						}
					}, {
						type: 'linear',
						display: true,
						position: 'right',
						id: lineData.yaxis,
						scaleLabel: {
							display: true,
							labelString: lineData.unit
						},
						ticks: {
							min: 0,
							//suggestedMin: 0,    // minimum will be 0, unless there is a lower value.
							// OR //
							//beginAtZero: true,   // minimum value will be 0.
							callback: function(value) {
								return number_format(value);
							}
						},
						gridLines: {
							drawOnChartArea: false
						},
					}
					],

				}
			}
		}


		for(idx in barData){
			var tmp = this.createDataset(barData[idx],false);
			config.data.datasets.push(tmp);
		};


		return config;
	}




	this.createBarChartConfig = function (labels, datasets, fill) {
		var config = {
			type: 'bar',
			data:{
				labels: labels,
				datasets:[]
			},
			options: option
		}

		for(idx in datasets){
			var tmp = this.createDataset(datasets[idx],fill);
			config.data.datasets.push(tmp);
		};


		return config;
	}

	this.createDoughnutChartConfig = function (labels,datasets,fill) {

		var color = new Array();

		for(idx in datasets){
			color.push(this.randomColor());
		};


		var config = {
			    type: 'doughnut',
			    data: {
			        datasets: [{
			            data: datasets,
			            backgroundColor: color,
			            label: '총 에너지'
			        }],
			        labels: labels

			    },
			    options: {
			        responsive: true,

			        legend: {
			            position: 'bottom',
			        }
			    }
			};


		return config;

	}

	this.createBarNLine = function(title,barData,lineData) {

		var barChartOptions  = {
			type: 'bar',
			data: {

				labels  :title,
				datasets: [
					{
						type: 'bar',
						label               : barData.title,
						borderColor : barData.borderColor,
						backgroundColor: barData.backgroundColor,
						data                : barData.data,
						yAxisID: barData.yaxis
					},
					{
						type: 'line',
						label               : lineData.title,
						borderColor : lineData.borderColor,
						backgroundColor: lineData.backgroundColor,
						data                : lineData.data,
						fill  : false,
						yAxisID: lineData.yaxis
					}
				]
			},
			options: {
				responsive: true,
				legend: {
					position: 'bottom',
				},tooltips: {
					mode: 'index',
					intersect: false,
					callbacks: {
						label: function (tooltipItem, chart) {
							var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
							return datasetLabel + number_format(tooltipItem.yLabel, 2);
						}
					}
				},scales: {
					yAxes: [{
						type: 'linear',
						display: true,
						position: 'left',
						id: barData.yaxis,
						ticks: {
							callback: function(value) {
								return number_format(value);
							}
						},
					}, {
						type: 'linear',
						display: true,
						position: 'right',
						id: lineData.yaxis,
						ticks: {
							callback: function(value) {
								return number_format(value);
							}
						},

						gridLines: {
							drawOnChartArea: false
						},
					}],

				}
			}
		}

		return barChartOptions;
	}


	this.createLine = function(title,lineData) {

		var barChartOptions  = {
			type: 'bar',
			data: {

				labels  :title,
				datasets: [
					{
						type: 'line',
						label               : lineData.title,
						//borderColor : lineData.borderColor,
						//backgroundColor: lineData.backgroundColor,
						data                : lineData.data,
						fill  : false
					}
				]
			},
			options: {
				responsive: true,
				legend: {
					position: 'bottom',
				},tooltips: {
					mode: 'index',
					intersect: false,
					callbacks: {
						label: function (tooltipItem, chart) {
							var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
							return datasetLabel + number_format(tooltipItem.yLabel, 2);
						}
					}
				}
			}
		}

		return barChartOptions;
	}

	this.createRaderDataset = function(dataset,fill) {
		if(dataset.title == undefined || dataset.title == "") {
			dataset.title = "label"
		}

		var area;


		if( fill == undefined) {
			area = false;
		} else {
			area = fill;
		}

		var dataElements =  {
			label: dataset.title,
			data: dataset.data,
			backgroundColor: dataset.backgroundColor,
			borderColor: dataset.borderColor,
			fill: '-1'
		}

		return dataElements;
	}


	this.createDataset = function(dataset,fill) {
		if(dataset.title == undefined || dataset.title == "") {
			dataset.title = "label"
		}
		
		var area;
		
		
		if( fill == undefined) {
			area = false;
		} else {
			area = fill;
		}
		
		var dataElements =  {
				label: dataset.title,
				data: dataset.data,
				backgroundColor: dataset.backgroundColor,
				borderWidth: 1,
				borderColor: dataset.borderColor,
				fill:area
		}
				
		return dataElements;
	}


	this.createDatasetN = function(dataset) {
		if(dataset.title == undefined || dataset.title == "") {
			dataset.title = "label"
		}

		var dataElements =  {
			label: dataset.title,
			data: dataset.data,
			backgroundColor: dataset.backgroundColor,
			borderWidth: 1,
			borderColor: dataset.borderColor
		}

		return dataElements;
	}


}

function DataElement(title,data) {
	this.title = title;
	this.data = data;
		
	this.randomColor = function() {
		var r = Math.floor(Math.random() * 255);
	    var g = Math.floor(Math.random() * 255);
	    var b = Math.floor(Math.random() * 255);
	    return "rgba(" + r + "," + g + "," + b + ","+0.4+")";
	}
	
	this.backgroundColor = this.randomColor();
	this.borderColor = this.randomColor();
}

function DataElement(title,data,yaxis) {

	this.title = title;
	this.data = data;

	this.yaxis = yaxis;
	this.yAxisID = yaxis;

	this.randomColor = function() {
		var r = Math.floor(Math.random() * 255);
		var g = Math.floor(Math.random() * 255);
		var b = Math.floor(Math.random() * 255);
		return "rgba(" + r + "," + g + "," + b + ","+0.4+")";
	}

	this.backgroundColor = this.randomColor();
	this.borderColor = this.randomColor();

}

function DataElement(title,data,yaxis,unit) {

	this.title = title;
	this.data = data;

	this.yaxis = yaxis;
	this.unit = unit;

	this.randomColor = function() {
		var r = Math.floor(Math.random() * 255);
		var g = Math.floor(Math.random() * 255);
		var b = Math.floor(Math.random() * 255);
		return "rgba(" + r + "," + g + "," + b + ","+0.4+")";
	}

	this.backgroundColor = this.randomColor();
	this.borderColor = this.randomColor();

}



function number_format(number, decimals, dec_point, thousands_sep) {
// *     example: number_format(1234.56, 2, ',', ' ');
// *     return: '1 234,56'
	number = (number + '').replace(',', '').replace(' ', '');
	var n = !isFinite(+number) ? 0 : +number,
		prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
		sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
		dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
		s = '',
		toFixedFix = function (n, prec) {
			var k = Math.pow(10, prec);
			return '' + Math.round(n * k) / k;
		};
	// Fix for IE parseFloat(0.55).toFixed(0) = 0;
	s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
	if (s[0].length > 3) {
		s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
	}
	if ((s[1] || '').length < prec) {
		s[1] = s[1] || '';
		s[1] += new Array(prec - s[1].length + 1).join('0');
	}
	return s.join(dec);
}

function updateArray(myArray, oldValue, newValue) {
	if (!myArray instanceof Array) return;

   for (let i in myArray){
	   if (myArray[i] == -999) {
		   myArray[i] = newValue;
	   }
   }

	return myArray;
}



