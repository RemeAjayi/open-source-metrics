ALTER TABLE pull_request
    DROP COLUMN user_type_id,
    DROP COLUMN user_type_name,
    ADD COLUMN user_type TEXT;