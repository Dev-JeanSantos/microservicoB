export DEFAULT_REGION=us-east-1
export AWS_DEFAULT_REGION=us-east-1
#!/bin/bash
echo "[INFO] - MICROSERVIÇO-B - LOCALSTACK"

echo "[INFO] - CRIAÇÃO S3"
aws --endpoint-url http://localhost:4566 --region us-east-1  s3api create-bucket --bucket mybucket

echo "[INFO] - PERMISSÕES S3"
aws --endpoint-url http://localhost:4566 s3api put-bucket-acl --bucket mybucket --acl public-read

