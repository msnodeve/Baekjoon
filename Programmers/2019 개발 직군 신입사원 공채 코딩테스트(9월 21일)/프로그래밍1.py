import re
def solution(emails):
    result = 0
    email_regex = re.compile('^[a-zA-Z0-9+.]+@[a-zA-Z0-9-]+\.[com|net|org]+$')
    for email in emails:
        if p.match(email):
            result += 1
    return result