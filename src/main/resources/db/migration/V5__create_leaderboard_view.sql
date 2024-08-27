CREATE VIEW repo_activity_view AS
WITH current_ranks AS (
    SELECT
        RANK() OVER (ORDER BY COUNT(*) DESC) AS current_rank,
        repo,
        COUNT(*) AS pull_request_count
    FROM
        pull_request
    WHERE
        CAST(created_at AS TIMESTAMP) <= NOW() -- Include all pull requests updated up to the current time
    GROUP BY
        repo
    ORDER BY
        pull_request_count DESC
    LIMIT 20
),
previous_ranks AS (
    SELECT
        RANK() OVER (ORDER BY COUNT(*) DESC) AS previous_rank,
        repo
    FROM
        pull_request
    WHERE
        CAST(created_at AS TIMESTAMP) <= NOW() - INTERVAL '3 DAY' -- Exclude pull requests updated in the last hour
    GROUP BY
        repo
    ORDER BY
        COUNT(*) DESC
    LIMIT 20
)
SELECT
    cr.current_rank,
    cr.repo,
    cr.pull_request_count,
    pr.previous_rank
FROM
    current_ranks cr
LEFT JOIN
    previous_ranks pr
ON
    cr.repo = pr.repo
ORDER BY
    cr.current_rank;
