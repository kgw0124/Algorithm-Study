import datetime

def solution(date1, date2):
    datetime1 = datetime.date(date1[0], date1[1], date1[2])
    datetime2 = datetime.date(date2[0], date2[1], date2[2])
    return int(datetime1 < datetime2)