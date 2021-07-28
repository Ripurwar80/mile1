# provider.tf

# Specify the provider and access details
provider "aws" {
  profile                 = "default"
  region                  = var.aws_region
  access_key = "AKIAVH24FXJXWRFFCROQ" #has to put
  secret_key = "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" #has to put
  #i'm trying to bind them in a variable and pass for the security purpose
}
