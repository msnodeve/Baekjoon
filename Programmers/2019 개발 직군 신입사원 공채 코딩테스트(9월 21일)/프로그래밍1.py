import re
def solution(emails):
    result = 0
    p = re.compile('^[a-zA-Z0-9+.]+@[a-zA-Z0-9-]+\.[com|net|org]+$')
    for e in emails:
        if p.match(e):
            result += 1
    return result