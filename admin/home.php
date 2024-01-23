<h1 class="">Welcome to <?php echo $_settings->info('name') ?></h1>
<hr>
<?php
 $sched_arr=array();
?>
<div class="row">
    <div class="col-lg-3 col-6">
    <!-- small box -->
    <div class="small-box bg-info">
        <div class="inner">
        <h3><?php echo $conn->query("SELECT * FROM `assembly_hall` ")->num_rows; ?></h3>

        <p>Total Hall/Room</p>
        </div>
        <div class="icon">
        <i class="fas fa-door-open"></i>
        </div>
        <a href="./?page=assembly_hall" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
    </div>
    </div>
    <!-- ./col -->
    <div class="col-lg-3 col-6">
    <!-- small box -->
    <div class="small-box bg-success">
        <div class="inner">
        <h3><?php echo $conn->query("SELECT * FROM `schedule_list` where date(datetime_start) >= '".date("Y-m-d")."' ")->num_rows; ?></h3>

        <p>Total Reservations</p>
        </div>
        <div class="icon">
        <i class="fa fa-calendar-week"></i>
        </div>
        <a href="./?page=schedules" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
    </div>
    </div>
</div>