CREATE TABLE labels (
    pull_request_id VARCHAR(255) NOT NULL,
    label_names VARCHAR(255) NOT NULL,
    PRIMARY KEY (pull_request_id, label_names),
    FOREIGN KEY (pull_request_id) REFERENCES pull_request(id)
);