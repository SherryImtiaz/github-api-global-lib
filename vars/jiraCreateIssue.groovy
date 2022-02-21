def call(Map config=[:]) {
  def rawBody = libraryResource 'com/planetpope/api/jira/createIssue.json'
  def binding = [
    key: "${config.key}",
    summary: "${config.summary}",
    description: "${config.description}",
    issueTypeName: "${config.issueTypeName}"
  ]
  def render = renderTemplate(rawBody,binding)
 def render2 = render.replaceAll("[\\t\\n\\r\\f\\v]","")
  def cmd = """curl -D- -u $JIRA_CREDENTIALS -X POST --data \"${render2}\" -H \"Content-Type: application/json\" $JIRA_URL/rest/api/2/issue"""
  echo cmd
// bat(script:cmd)
 
}
