package home_work_6;

import org.junit.jupiter.api.Test;

import static home_work_6.GitHabPage.ISSUE_NAME;

public class TestWithStepAnnotations {

    GitHabPage gitHabPage = new GitHabPage();

    @Test
    void checkIssuePresenting() {
        gitHabPage.openGitHabSite();
        gitHabPage.clickIssuesTab();
        gitHabPage.checkIssueByText(ISSUE_NAME);
    }
}
