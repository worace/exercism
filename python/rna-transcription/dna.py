mappings = {"G": "C", "C": "G", "T": "A", "A": "U"}

def to_rna(sequence):
    return "".join([mappings.get(c) for c in sequence])
