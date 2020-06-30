$(document).ready(function() {
  // การลงเวลาเข้าเรียน
  setTimeout(function() {
    $("#loading-statistic").fadeOut();
  }, 200);

  // สถานะนักเรียน
  setTimeout(function() {
    $(".loading-student").fadeOut();
  }, 500);

  // Daily
  setTimeout(function() {
    $("#loading-daily").fadeOut();
  }, 300);

  // ยอดรวมทั้งหมดในสัปดาห์
  let echartElemWeekly = document.getElementById("echart-weekly");
  if (echartElemWeekly) {
    let echart = echarts.init(echartElemWeekly);
    echart.setOption({
      grid: {
        left: "8px",
        right: "8px",
        bottom: "0",
        top: "8px",
        containLabel: true
      },
      xAxis: [
        {
          type: "category",
          data: ["11", "12", "13", "14", "15"],
          axisTick: {
            show: false
          }
        }
      ],
      yAxis: [
        {
          type: "value",
          axisLine: {
            show: false
          },
          axisTick: {
            show: false
          }
        }
      ],
      tooltip: {
        show: true,
        backgroundColor: "rgba(0, 0, 0, .8)"
      },
      series: [
        {
          name: "เติมเงิน",
          data: [150, 40, 0, 100, 120],
          type: "bar",
          barGap: 0,
          smooth: true,
          itemStyle: {
            color: colors.secondarySoft,
            barBorderColor: colors.secondary,
            emphasis: {
              shadowBlur: 5,
              shadowOffsetX: 0,
              shadowOffsetY: -2,
              shadowColor: "rgba(0, 0, 0, 0.3)"
            }
          }
        },
        {
          name: "รายจ่าย",
          data: [100, 110, 100, 20, 130],
          type: "bar",
          smooth: true,
          itemStyle: {
            color: colors.primarySoft,
            barBorderColor: colors.primary,
            emphasis: {
              shadowBlur: 5,
              shadowOffsetX: 0,
              shadowOffsetY: -2,
              shadowColor: "rgba(0, 0, 0, 0.3)"
            }
          }
        }
      ]
    });
    $(window).on("resize", function() {
      setTimeout(() => {
        echart.resize();
      }, 500);
    });
    $(".menu-toggle").on("click", function() {
      setTimeout(() => {
        echart.resize();
      }, 240);
    });
    $(".breadcrumb-collapse i").on("click", function() {
      setTimeout(() => {
        echart.resize();
      }, 250);
    });
    setTimeout(function() {
      echart.resize();
    }, 500);
  }
  setTimeout(function() {
    $("#loading-weekly").fadeOut();
  }, 600);

  // ยอดการใช้เงินประจำเดือน
  let echartElemMonthly = document.getElementById("echart-monthly");
  if (echartElemMonthly) {
    let echart = echarts.init(echartElemMonthly);
    echart.setOption({
      ...echartOptions.lineNoAxis,
      ...{
        grid: {
          top: 40,
          right: 0,
          left: 0,
          bottom: 40
        },
        xAxis: {
          type: "category",
          data: [
            "1 ก.พ.",
            "2 ก.พ.",
            "3 ก.พ.",
            "4 ก.พ.",
            "5 ก.พ.",
            "6 ก.พ.",
            "7 ก.พ.",
            "8 ก.พ.",
            "9 ก.พ.",
            "10 ก.พ.",
            "11 ก.พ.",
            "12 ก.พ.",
            "13 ก.พ.",
            "14 ก.พ.",
            "15 ก.พ.",
            "16 ก.พ.",
            "17 ก.พ.",
            "18 ก.พ.",
            "19 ก.พ.",
            "20 ก.พ.",
            "21 ก.พ.",
            "22 ก.พ.",
            "23 ก.พ.",
            "24 ก.พ.",
            "25 ก.พ.",
            "26 ก.พ.",
            "27 ก.พ.",
            "28 ก.พ."
          ],
          axisLine: {
            show: true
          },
          axisTick: {
            show: false
          },
          axisLabel: {
            color: colors.dark,
            interval: 6,
            showMinLabel: false
          }
        },
        series: [
          {
            data: [
              40,
              30,
              50,
              80,
              120,
              40,
              80,
              20,
              90,
              30,
              80,
              40,
              90,
              20,
              80,
              30,
              45,
              50,
              110,
              90,
              145,
              70,
              30,
              80,
              50,
              10,
              100,
              130
            ],
            type: "line",
            smooth: true,
            lineStyle: {
              color: colors.secondary,
              width: 3
            },
            itemStyle: {
              borderColor: colors.secondary
            }
          }
        ]
      }
    });
    $(window).on("resize", function() {
      setTimeout(() => {
        echart.resize();
      }, 500);
    });
    $(".menu-toggle").on("click", function() {
      setTimeout(() => {
        echart.resize();
      }, 240);
    });
    $(".breadcrumb-collapse i").on("click", function() {
      setTimeout(() => {
        echart.resize();
      }, 250);
    });
    setTimeout(function() {
      echart.resize();
    }, 500);
  }
  setTimeout(function() {
    $("#loading-monthly").fadeOut();
  }, 800);
});