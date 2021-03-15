POST_NEW_JOB_OBJECT=post-new-job.event.avsc
ACCEPTJOB_JOB_APPLICATION_OBJECT=accept-job-application.event.avsc
REMOVE_JOB_APPLICATION_OBJECT=post-new-job.event.avsc
DELETE_JOB_MODEL=delete-job.event.avsc

curl -X GET \
  -H "Authorization: Bearer ${GCLOUD_STORAGE_ACCESS_TOKEN}" \
  -o "src/main/resources/avro/${ACCEPTJOB_JOB_APPLICATION_OBJECT}" \
  "https://storage.googleapis.com/storage/v1/b/passnet-event-avro-models/o/${ACCEPTJOB_JOB_APPLICATION_OBJECT}?alt=media"