#!/bin/bash

files=(
    post-new-job.event.avsc
    accept-job-application.event.avsc
    delete-job.event.avsc
    remove-job-application.event.avsc
)

for file in "${files[@]}"
do
    curl -X GET \
    -H "Authorization: Bearer ${GCLOUD_STORAGE_ACCESS_TOKEN}" \
    -o "src/main/resources/avro/${file}" \
    "https://storage.googleapis.com/storage/v1/b/${PASSNET_EVENT_AVRO_MODEL_BUCKET}/o/${file}?alt=media"
done

