def solution(angle):
    if angle % 90 == 0:
        return angle / 90 * 2
    elif 0 < angle and angle < 90:
        return 1
    else:
        return 3