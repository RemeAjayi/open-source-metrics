CREATE TABLE pull_request (
    id TEXT PRIMARY KEY,
    title TEXT,
    url TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    closed_at TIMESTAMP,
    merged_at TIMESTAMP,
    state TEXT,
    body TEXT,
    repo TEXT,
    user_type_id TEXT,
    user_type_name TEXT,
    label_names TEXT[]
);