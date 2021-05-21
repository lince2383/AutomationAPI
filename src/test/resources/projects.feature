Feature: Projects

  Scenario: I want to create a new project

    Given I have authentication to todo.ly
    When I send POST request 'api/projects.json' with json and BASIC authentication
  """
{
   "Content": "Mi Primer Proyecto",
   "Icon": "4"
}
  """
    Then I expected the response code 200
    And I expected the response body is equal
    """
  {
    "Id": EXCLUDE,
    "Content": "Mi Primer Proyecto",
    "ItemsCount": 0,
    "Icon": 4,
    "ItemType": 2,
    "ParentId": null,
    "Collapsed": false,
    "ItemOrder": EXCLUDE,
    "Children": [],
    "IsProjectShared": false,
    "ProjectShareOwnerName": null,
    "ProjectShareOwnerEmail": null,
    "IsShareApproved": false,
    "IsOwnProject": true,
    "LastSyncedDateTime": EXCLUDE,
    "LastUpdatedDate": EXCLUDE,
    "Deleted": false,
    "SyncClientCreationId": null
}
     """
    And I get the property value 'Id' and save on ID_PROJECT

    And I get the property value 'Content' and save on Titulo

    When I send PUT request 'api/projects/ID_PROJECT.json' with json and BASIC authentication
    """
    {
      "Content": "Bianca"
    }
     """
    Then I expected the response code 200

    When I send DELETE request 'api/projects/ID_PROJECT.json' with json and BASIC authentication
    """

    """

    Then I expected the response code 200

    When I send GET request 'api/projects.json' with json and BASIC authentication
     """

     """
    Then I expected the response code 200
