def solution(schedules, timelogs, startday):
    answer = 0
    day_check_list = get_day_list(startday)
    
    for i in range(0, len(schedules)):
        check = 0
        time_limit = time_calc(schedules[i])
        timelog = timelogs[i]
        
        for day in range(0, 7):
            if day_check_list[day] == 1 and int(timelog[day]) <= time_limit:
                check += 1
                
        if check == 5:
            answer += 1
    return answer

def get_day_list(startday):
    day = [1,1,1,1,1,0,0]
    return day[startday - 1:] + day[:startday - 1]
    
    
def time_calc(schedule):
    time = int(schedule)
    h = int(time / 100)
    m = int(time % 100) + 10
    
    if (m >= 60):
        return (h + 1) * 100 + m % 60
    else:
        return h * 100 + m