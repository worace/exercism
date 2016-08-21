def eq(a,b):
    return a == b

def distance(a, b):
    diffs = [pair for pair in zip(a,b) if not eq(*pair)]
    return len(diffs)
