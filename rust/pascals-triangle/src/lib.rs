//     1
//    1 1
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1

//     1
//     1 1
//     1 2 1
//     1 3 3 1
//     1 4 6 4 1

pub struct PascalsTriangle {
    row_count: u32
}


fn next_row(prev_row: &Vec<u32>) -> Vec<u32> {
    (0..prev_row.len()+1).map(|i| {
        let mut value = 0;
        if i > 0 {
            match prev_row.get(i - 1) {
                Some(x) => {value += *x},
                None => {}
            }
        }

        match prev_row.get(i) {
            Some(x) => {value += *x},
            None => {}
        }

        value
    }).collect()
}

impl PascalsTriangle {
    pub fn new(row_count: u32) -> Self {
        PascalsTriangle { row_count: row_count }
    }

    pub fn rows(&self) -> Vec<Vec<u32>> {
        let mut prev_row = vec![1];
        let mut rows = Vec::new();
        for _ in 0..self.row_count {
            let next = next_row(&prev_row);
            rows.push(prev_row);
            prev_row = next;
        }
        rows
    }
}
