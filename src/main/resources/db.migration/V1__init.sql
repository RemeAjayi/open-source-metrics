CREATE TABLE pull_requests (
    id TEXT PRIMARY KEY,
    title TEXT,
    user_type TEXT,
    url TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    closed_at TIMESTAMP,
    merged_at TIMESTAMP,
    state TEXT,
    body TEXT,
    repo TEXT
);